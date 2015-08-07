import Ui from "./Ui";

export default class FeatureContainer {
    static displayFeatures(allFeatures, categories) {
        let categoryToFeatureMap = FeatureContainer._mapFeaturesToCategory(allFeatures);
        categories.sort((a, b) => a.index - b.index);

        let row;
        for (let category of categories) {
            let features = categoryToFeatureMap.get(category.name);

            if (FeatureContainer._needsNewRow()) {
                row = $("<div class='row'>").appendTo(Ui.featureContainer);
            }
            let column = $("<div class='ui stretched column'>").appendTo(row);
            let container = $("<div class='ui segment'>").appendTo(column);

            container.append("<h3>" + category.name + "</h3>");
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

    static _needsNewRow() {
        const MAX_CATEGORIES_PER_ROW = 3;
        return Ui.featureContainer.find(".column").length % MAX_CATEGORIES_PER_ROW === 0;
    }
}
