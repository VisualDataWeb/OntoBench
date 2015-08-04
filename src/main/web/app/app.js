import Ui from "./Ui";
import FeatureContainer from "./FeatureContainer";
import Generator from "./Generator";

Ui.initializeDefaults();

$.getJSON("/features.json").done(FeatureContainer.displayFeatures);
$.getJSON("/formats.json").done(Ui.displayFormats);
