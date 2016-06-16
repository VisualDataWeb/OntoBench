import Generator from "./Generator";

const WEBVOWL_URL = "http://vowl.visualdataweb.org/webvowl/#iri=";

export default class Ui {
    static initializeDefaults() {
        Ui._setupQuickGuide();
        $(".message .close").on("click", function () {
            $(this).closest(".message").transition("fade");
        });

        Ui.tabMenu.find(".item").tab();
        Ui.tabMenu.find("[data-tab='generator']").click(() => Ui._generate());
        $("#generator-shortcut-button").click(() => $("[data-tab='generator']").click());
        Ui.webvowlButton.click(() => window.open(WEBVOWL_URL + Generator.longUrl, "_blank"));

        Ui._initializeSelectionButtons(Ui.featureTab);

        Ui.ontologyUrl.click(() => Ui.ontologyUrl.select());
        Ui.urlType.dropdown({
            action: "activate",
            onChange: () => {
                Ui.displayUrl();
            }
        });
        Ui.urlType.find("[data-value='short']").popup({
            on: "click",
            target: Ui.urlType
        });
        Ui.ontologyText.click(() => Ui.ontologyText.select());
    }

    static displayFormats(formats) {
        formats.sort((a, b) => a.name.localeCompare(b.name));

        formats.forEach(function (format) {
            let option = $("<div class='item' data-value='" + format.extension + "'>");
            option.data(format).text(format.name);
            option.appendTo("#format-list");
        });

        Ui._initializeFormats(formats.find(format => format.default));
    }

    static _initializeFormats(defaultFormat) {
        let element = $("#format-dropdown");
        if (defaultFormat) {
            element.dropdown("set selected", defaultFormat.extension);
        } else {
            element.dropdown();
        }
        element.dropdown({
            action: "activate",
            onChange: () => {
                Ui._generate();
            }
        });
        element.removeClass("loading");
    }

    static displayPresets(presets) {
        presets.sort((a, b) => a.index - b.index);

        presets.forEach(preset => {
            let button = $("<button class='ui fluid green labeled icon button'>").text(preset.name);
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

    static displayUrl() {
        let type = Ui.urlType.dropdown("get value");
        let url = type === "short" ? Generator.shortUrl : Generator.longUrl;

        Ui.ontologyUrl.val(url);
        Ui.downloadButton.attr("href", url);
    }

    static get selectedExtension() {
        return $("#format-dropdown").dropdown("get value");
    }

    static get selectedFeatures() {
        var selectedCheckboxes = Ui.featureContainer.find(":checked").parent();

        var features = selectedCheckboxes.map(function () {
            return $(this).data();
        });

        return features.get();
    }

    static displayOntology(ontology) {
        Ui.ontologyText.css("height", 0);
        Ui.ontologyText.text(ontology.toString());
        Ui.ontologyText.css("height", Ui.ontologyText.prop("scrollHeight") + 2); // 2px let the scrollbar disappear
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
            Ui.webvowlButton.hide();
            Ui.ontologyTextContainer.hide();
            $("#ontology-generation-error-info").removeClass("hidden").show();
        } else {
            $("#ontology-generation-error-info").hide();
            Ui.webvowlButton.show();
            Ui.ontologyTextContainer.show();
        }
    }

    static _initializeSelectionButtons(container) {
        container.on("click", ".select-all-button", function () {
            $(this).parent().parent().parent().find(":checkbox").prop("checked", true)
        });
        container.on("click", ".select-none-button", function () {
            $(this).parent().parent().parent().find(":checkbox").prop("checked", false)
        });
        container.on("click", ".invert-selection-button", function () {
            $(this).parent().parent().parent().find(":checkbox").each(function () {
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

    static _generate() {
        Ui.displayOntology("");
        Generator.resetAndGenerate();
    }

    static get tabMenu() {
        return $("#tab-menu");
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

    static get webvowlButton() {
        return $("#webvowl-button");
    }
}
