import Ui from "./Ui";

export default class Generator {

    static resetAndGenerate() {
        Generator.reset();
        Generator._generate(Generator._displayUrlAndOntology);
    }

    static reset() {
        Generator._featureString = Ui.selectedFeatures.map(f => f.token).join(",");
        Generator._shortUrlBase = undefined;
        Generator._ontology = undefined;
    }

    static get shortUrl() {
        return Generator._shortUrlBase + "." + Ui.selectedExtension;
    }

    static get longUrl() {
        return location.href + "ontology/ontology." + Ui.selectedExtension + "?features=" + Generator._featureString;
    }

    static _generate(onReady) {
        Ui.indicateGeneration();
        $.ajax({
            url: Generator.longUrl,
            dataType: "text"
        }).done((ontology, textStatus, xhr) => {
            Generator._ontology = ontology;
            Generator._shortUrlBase = location.href.slice(0, -1) + xhr.getResponseHeader("Short-Path");
            if (onReady) {
                onReady(ontology);
            }
        }).fail(() => Ui.showErrorMessage());
    }

    static _displayUrlAndOntology(ontology) {
        Ui.displayUrl();
        Ui.displayOntology(ontology);
    }

}
