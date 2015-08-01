import Ui from "./Ui";

export default class FeatureList {
    static displayFeatures(features) {
        features.forEach(feature => {
            let checkbox = FeatureList._createFeatureCheckbox(feature);
            let container = $("<div>").addClass("item").append(checkbox);
            container.appendTo(Ui.featureList);
        });
    }

    static _createFeatureCheckbox(feature) {
        let id = feature.token + "-feature";

        let container = $("<div>").data(feature).addClass("ui checkbox");
        $("<input type='checkbox' id='" + id + "'>").appendTo(container);
        $("<label>").attr("for", id).text(feature.name).appendTo(container);

        return container;
    }
}
