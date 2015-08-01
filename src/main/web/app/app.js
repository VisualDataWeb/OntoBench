import Ui from "./Ui";
import FeatureList from "./FeatureContainer";
import Generator from "./Generator";

Ui.initializeDefaults();

$.getJSON("/features.json").done(FeatureList.displayFeatures);
$.getJSON("/formats.json").done(displayFormats);

function displayFormats(formats) {
    formats.forEach(function (format) {
        let option = $("<div class='item' data-value='" + format.extension + "'>");
        option.data(format).text(format.name);
        option.appendTo("#format-list");
    });

    Ui.initializeFormats(formats.find(format => format.default));
}
