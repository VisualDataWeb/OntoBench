import Ui from "./Ui";
import FeatureContainer from "./FeatureContainer";

$.ajax({url: "version", dataType: "text"}).done((version) => $("#version").text("v" + version));

Ui.initializeDefaults();

$.getJSON("categories.json").done((categories) => {
    $.getJSON("features.json").done(features => FeatureContainer.displayFeatures(features, categories));
});
$.getJSON("formats.json").done(Ui.displayFormats);
$.getJSON("presets.json").done(Ui.displayPresets);
