import Ui from "./Ui";
import FeatureList from "./FeatureContainer";
import Generator from "./Generator";

Ui.initializeDefaults();

$.getJSON("/features.json").done(FeatureList.displayFeatures);
$.getJSON("/formats.json").done(Ui.displayFormats);
