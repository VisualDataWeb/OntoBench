import Ui from "./Ui";
import Generator from "./Generator";

Ui.initializeDefaults();

$.getJSON("/features.json").done(displayFeatures);
$.getJSON("/formats.json").done(displayFormats);

function displayFeatures(features) {
    features.forEach(function (feature) {
        var checkbox = createFeatureCheckbox(feature);
        var container = $("<div>").addClass("item").append(checkbox);
        container.appendTo("#feature-list");
    });
}

function createFeatureCheckbox(feature) {
    let id = feature.token + "-feature";

    let container = $("<div>").data(feature).addClass("ui checkbox");
    $("<input type='checkbox' id='" + id + "'>").appendTo(container);
    $("<label>").attr("for", id).text(feature.name).appendTo(container);
    return container;
}

function displayFormats(formats) {
    formats.forEach(function (format) {
        let option = $("<div class='item' data-value='" + format.extension + "'>");
        option.data(format).text(format.name);
        option.appendTo("#format-list");
    });

    formats.some(value => {
        if (value.default) {
            Ui.initializeFormats(value);
            return true;
        }
    });
}
