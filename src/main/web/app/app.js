import Ui from "./Ui";
import FeatureContainer from "./FeatureContainer";
import Generator from "./Generator";

Ui.initializeDefaults();

$.getJSON("/categories.json").done((categories) => {
    $.getJSON("/features.json").done(features => FeatureContainer.displayFeatures(features, categories));
});
$.getJSON("/formats.json").done(Ui.displayFormats);
$.getJSON("/presets.json").done(Ui.displayPresets);
