import Generator from "./Generator";

export default class Ui {
    static initializeDefaults() {
        $(".menu .item").tab();

        $("#url-type").dropdown({
            action: "activate",
            onChange: (value) => {
                if (value === "short") {
                    Generator.createOrGetShortUrl(Ui.displayUrl);
                } else {
                    Ui.displayUrl(Generator.longUrl);
                }
            }
        }).dropdown("save defaults");

        $("#generate-button").click(function () {
            Ui.resetUrlType();
            Generator.generateAndDisplay();
        });
    }

    static initializeFormats(defaultFormat) {
        let element = $("#format-dropdown");
        if (defaultFormat) {
            element.dropdown("set selected", defaultFormat.extension);
        } else {
            element.dropdown();
        }
    }

    static displayUrl(url) {
        $("#ontology-url").val(url);
    }

    static get selectedExtension() {
        var extension = $("#format-list").find(".selected.item").attr("data-value");
        if (extension) {
            extension = "." + extension;
        } else {
            extension = "";
        }
        return extension;
    }

    static get selectedFeatures() {
        var selectedCheckboxes = $("#feature-list").find(":checked").parent();

        var features = selectedCheckboxes.map(function () {
            return $(this).data();
        });

        return features.get();
    }

    static resetUrlType() {
        $("#url-type").removeClass("disabled").dropdown("restore defaults");
    }
}
