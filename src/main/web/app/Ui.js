import Generator from "./Generator";

export default class Ui {
    static initializeDefaults() {
        $(".menu .item").tab();
        $(".message .close").on("click", function () {
            $(this).closest(".message").transition("fade");
        });

        Ui._setupQuickGuide();

        Ui._initializeSelectionButtons(Ui.featureTab);
        $("#generate-button").click(() => {
            Ui.resetOntologyUrlInput();
            Generator.resetAndGenerate();
        });
        $("#generator-shortcut-button").click(() => {
            $("[data-tab='generator']").click();
        });

        Ui.ontologyUrl.click(() => Ui.ontologyUrl.select());
        Ui.urlType.dropdown({
            action: "activate",
            onChange: (value) => {
                if (value === "short") {
                    Generator.useShortUrl();
                } else {
                    Generator.useLongUrl();
                }
            }
        }).dropdown("save defaults");
    }

    static resetOntologyUrlInput() {
        Ui.urlType.removeClass("disabled").dropdown("restore defaults");
        Ui.downloadButton.removeClass("disabled");
    }

    static displayFormats(formats) {
        formats.sort((a, b) => a.name.localeCompare(b.name));

        formats.forEach(function (format) {
            let option = $("<div class='item' data-value='" + format.extension + "'>");
            option.data(format).text(format.name);
            option.appendTo("#format-list");
        });

        Ui.initializeFormats(formats.find(format => format.default));
    }

    static initializeFormats(defaultFormat) {
        let element = $("#format-dropdown");
        if (defaultFormat) {
            element.dropdown("set selected", defaultFormat.extension);
        } else {
            element.dropdown();
        }
        element.removeClass("loading");
    }

    static displayPresets(presets) {
        presets.sort((a, b) => a.index - b.index);

        presets.forEach(preset => {
            let button = $("<button class='ui fluid green labeled icon button'>").data(preset).text(preset.name);
            button.append("<i class='plus icon'>");
            button.click(() => {
                Ui.features.filter(function () {
                    let token = $(this).parent().data().token;
                    return preset.tokens.includes(token);
                }).prop("checked", true);
            });

            let column = $("<div class='column'>").appendTo($("#preset-buttons"));
            button.appendTo(column);
        });
    }

    static initializeFeatureListing() {
        $(".checkbox").checkbox();
        $("#initial-feature-info").hide();
        Ui.featureContainer.removeClass("hidden");
    }

    static displayUrl(url) {
        Ui.ontologyUrl.val(url);
        Ui.downloadButton.attr("href", url);
    }

    static get selectedExtension() {
        return $("#format-list").find(".selected.item").attr("data-value");
    }

    static get selectedFeatures() {
        var selectedCheckboxes = Ui.featureContainer.find(":checked").parent();

        var features = selectedCheckboxes.map(function () {
            return $(this).data();
        });

        return features.get();
    }

    static displayOntology(ontology) {
        Ui.ontologyText.text(ontology.toString());
        Ui.indicateGeneration(false);
        Ui.showErrorMessage(false);
    }

    static indicateGeneration(shouldIndicate = true) {
        let container = Ui.ontologyTextContainer.removeClass("hidden");
        $("#initial-ontology-info").hide();

        if (shouldIndicate) {
            container.addClass("loading");
            Ui.ontologyText.empty();
        } else {
            container.removeClass("loading");
        }
    }

    static showErrorMessage(shouldShow = true) {
        Ui.indicateGeneration(false);
        if (shouldShow) {
            Ui.ontologyTextContainer.hide();
            $("#ontology-generation-error-info").removeClass("hidden").show();
        } else {
            $("#ontology-generation-error-info").hide();
            Ui.ontologyTextContainer.show();
        }
    }

    static _initializeSelectionButtons(container) {
        container.on("click", ".select-all-button", function () {
            $(this).parent().parent().find(":checkbox").prop("checked", true)
        });
        container.on("click", ".select-none-button", function () {
            $(this).parent().parent().find(":checkbox").prop("checked", false)
        });
        container.on("click", ".invert-selection-button", function () {
            $(this).parent().parent().find(":checkbox").each(function () {
                $(this).prop("checked", !$(this).prop("checked"));
            });
        });
    }

    static _setupQuickGuide() {
        const COOKIE_NAME = "hide-quick-guide";
        let quickGuide = $("#quick-guide");

        let hideQuickGuide = Cookies.get(COOKIE_NAME);
        if (!hideQuickGuide) {
            quickGuide.removeClass("hidden");
        }

        quickGuide.find(".close").on("click", () => {
            Cookies.set(COOKIE_NAME, true, {expires: 10 * 365})
        });
    }

    static get featureTab() {
        return $("#feature-tab");
    }

    static get featureContainer() {
        return $("#feature-container");
    }

    static get features() {
        return Ui.featureContainer.find(":checkbox");
    }

    static get urlType() {
        return $("#url-type");
    }

    static get ontologyText() {
        return $("#ontology-text");
    }

    static get ontologyTextContainer() {
        return Ui.ontologyText.parent().parent();
    }

    static get ontologyUrl() {
        return $("#ontology-url");
    }

    static get downloadButton() {
        return $("#download-button");
    }
}
