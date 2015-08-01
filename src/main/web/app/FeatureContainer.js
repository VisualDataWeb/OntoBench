import Ui from "./Ui";

export default class FeatureContainer {
    static displayFeatures(features) {
        let categoryMap = FeatureContainer._createCategoryMap(features);

        categoryMap.forEach((features, key) => {
            let container = $("<div class='ui segment'>");
            $("<h3>").text(key).appendTo(container);

            let list = $("<div class='ui list'>").appendTo(container);
            for (let feature of features) {
                let checkbox = FeatureContainer._createFeatureCheckbox(feature);
                $("<div class='item'>").append(checkbox).appendTo(list);
            }

            let column = $("<div class='ui stretched column'>").append(container);
            Ui.featureContainer.append(column);
        });

        Ui.initializeCheckboxes();
    }

    static _createCategoryMap(features) {
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

    static _createFeatureCheckbox(feature) {
        let id = feature.token + "-feature";

        let container = $("<div>").data(feature).addClass("ui checkbox");
        $("<input type='checkbox' id='" + id + "'>").appendTo(container);
        $("<label>").attr("for", id).text(feature.name).appendTo(container);

        return container;
    }
}
