import Ui from "./Ui";

export default class Generator {

    static resetAndGenerate() {
        Generator.reset();
        Generator.useLongUrl();
    }

    static reset() {
        Generator._isInitialized = true;
        Generator._featureString = Ui.selectedFeatures.map(f => f.token).join(",");
        Generator._shortUrlBase = undefined;
        Generator._shortUrlOntology = undefined;
        Generator._longUrlOntology = undefined;
    }

    static get shortUrl() {
        if (Generator._shortUrlBase) {
            return Generator._shortUrlBase + "?format=" + Ui.selectedExtension;
        }
    }

    static get longUrl() {
        return location.href + "ontology/?format=" + Ui.selectedExtension + "&features=" + Generator._featureString;
    }

    static useShortUrl() {
        if (!Generator.isInitialized()) {
            return;
        }

        if (Generator._shortUrlOntology) {
            Generator._displayUrlAndOntology(Generator.shortUrl, Generator._shortUrlOntology);
        } else {
            Generator._createShortUrl(Generator._displayUrlAndOntology);
        }
    }

    static useLongUrl() {
        if (!Generator.isInitialized()) {
            return;
        }

        if (Generator._longUrlOntology) {
            Generator._displayUrlAndOntology(Generator.longUrl, Generator._longUrlOntology);
        } else {
            Generator._createLongUrl(Generator._displayUrlAndOntology);
        }
    }

    static _createShortUrl(onReady) {
        Ui.indicateGeneration();
        $.ajax({
            method: "POST",
            url: Generator.longUrl,
            dataType: "text"
        }).done((ontology, textStatus, xhr) => {
            Generator._shortUrlBase = location.href.slice(0, -1) + xhr.getResponseHeader("Short-Path");
            Generator._shortUrlOntology = ontology;
            if (onReady) {
                onReady(Generator.shortUrl, ontology);
            }
        }).fail(() => Ui.showErrorMessage());
    }

    static _createLongUrl(onReady) {
        Ui.indicateGeneration();
        $.ajax({
            url: Generator.longUrl,
            dataType: "text"
        }).done(ontology => {
            Generator._longUrlOntology = ontology;
            if (onReady) {
                onReady(Generator.longUrl, ontology);
            }
        }).fail(() => Ui.showErrorMessage());
    }

    static _displayUrlAndOntology(url, ontology) {
        Ui.displayUrl(url);
        Ui.displayOntology(ontology);
    }

    static isInitialized() {
        return Generator._isInitialized;
    }

}
