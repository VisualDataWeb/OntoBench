import Ui from "./Ui";

export default class FeatureContainer {
    static displayFeatures(allFeatures, categories) {
        let categoryToFeatureMap = FeatureContainer._mapFeaturesToCategory(allFeatures);
        categories.sort((a, b) => a.index - b.index);

        for (let category of categories) {
            let features = categoryToFeatureMap.get(category.name);
            if (!features || !features.length) {
                continue;
            }

            let column = $("<div class='ui stretched column'>").appendTo(Ui.featureContainer);
            let container = $("<div class='ui olive segment'>").appendTo(column);

            let buttons = $("<div class='ui three fluid mini basic buttons'>").appendTo(container);
            FeatureContainer._addContainerSelectionButtons(buttons);
            container.append("<h3 class='ui medium header'>" + category.name + "</h3>");
            container.append(FeatureContainer._createFeatureList(features));
        }

        Ui.initializeFeatureListing();
    }

    static _mapFeaturesToCategory(features) {
        let map = new Map();

        for (let feature of features) {
            if (!map.has(feature.category)) {
                map.set(feature.category, []);
            }

            let categoryFeatures = map.get(feature.category);
            categoryFeatures.push(feature);
        }

        map.forEach(values => values.sort((a, b)=> a.name.localeCompare(b.name)));

        return map;
    }

    static _createFeatureList(features) {
        let list = $("<div class='ui list'>");
        for (let feature of features) {
            let checkbox = FeatureContainer._createFeatureCheckbox(feature);
            $("<div class='item'>").append(checkbox).appendTo(list);
        }
        return list;
    }

    static _createFeatureCheckbox(feature) {
        let id = feature.token + "-feature";

        let container = $("<div>").data(feature).addClass("ui checkbox");
        $("<input type='checkbox' id='" + id + "'>").appendTo(container);
        $("<label>").attr("for", id).text(feature.name).appendTo(container);

        return container;
    }

    static _addContainerSelectionButtons(container) {
        $("<div class='ui button select-all-button'>").text("Select all").appendTo(container);
        $("<div class='ui button select-none-button'>").text("Select none").appendTo(container);
        $("<div class='ui button invert-selection-button'>").text("Invert selection").appendTo(container);
    }
}
