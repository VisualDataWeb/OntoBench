import Ui from "./Ui";

export default class Generator {

    static generateAndDisplay() {
        Generator.storeSettings();
        Ui.displayUrl(Generator.longUrl);

        Ui.indicateGeneration(true);
        $.ajax({
            url: Generator.longUrl,
            dataType: "text"
        }).done(ontology => {
            Ui.displayOntology(ontology);
        });
    }

    static storeSettings() {
        Generator._featureString = Ui.selectedFeatures.map(f => f.token).join(",");
        Generator._shortUrlBase = undefined;
    }

    static get longUrl() {
        return location.href + "ontology" + Ui.selectedExtension + "?features=" + Generator._featureString;
    }

    static get shortUrl() {
        if (Generator._shortUrlBase) {
            return Generator._shortUrlBase + Ui.selectedExtension;
        }
    }

    static createOrGetShortUrl(callback) {
        if (!Generator.shortUrl) {
            Generator.createShortUrl(callback);
        } else {
            callback(Generator.shortUrl);
        }
    }

    static createShortUrl(callback) {
        $.ajax({
            method: "POST",
            url: Generator.longUrl
        }).done((data, textStatus, xhr) => {
            Generator._shortUrlBase = location.href.slice(0, -1) + xhr.getResponseHeader("Short-Path");
            callback(Generator.shortUrl);
        });
    }

}
