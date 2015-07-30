var ui = require("ui");

var htmlIds = {
    generateButton: "#generate-button",
    featureList: "#feature-list",
    formatDropdown: "#format-dropdown",
    formatList: "#format-list",
    ontologyUrl: "#ontology-url",
    ontologyText: "#ontology-text"
};

ui.initialize();

$.getJSON("/features.json")
    .done(function (features) {
              displayFeatures(features);
          });

$.getJSON("/formats.json")
    .done(function (formats) {
              displayFormats(formats);
          });

$(htmlIds.generateButton).click(function () {
    var url = location.href + "ontology" + getSelectedExtension() + "?features="
              + getFeatureString();

    $(htmlIds.ontologyUrl).val(url);
    $.ajax({
        url: url,
        dataType: "text"
    }).done(function (ontology) {
        $(htmlIds.ontologyText).text(ontology.toString());
    });
});

function displayFeatures(features) {
    features.forEach(function (feature) {
        var checkbox = createFeatureCheckbox(feature);
        var container = $("<div>").addClass("item").append(checkbox);
        container.appendTo(htmlIds.featureList);
    });
}

function createFeatureCheckbox(feature) {
    var id = feature.token + "-feature";

    var container = $("<div>").data(feature).addClass("ui checkbox");
    $("<input type='checkbox' id='" + id + "'>").appendTo(container);
    $("<label>").attr("for", id).text(feature.name).appendTo(container);
    return container;
}

function displayFormats(formats) {
    formats.forEach(function (format) {
        var option = $("<div class='item' data-value='" + format.extension + "'>");
        option.data(format).text(format.name);
        option.appendTo(htmlIds.formatList);
    });

    var defaultFormat = formats.find(function (format) {
        return format.default;
    });

    if (defaultFormat) {
        $(htmlIds.formatDropdown).dropdown("set selected", defaultFormat.extension);
    }
}

function getSelectedExtension() {
    var extension = $(htmlIds.formatList).find(".selected.item").attr("data-value");
    if (extension) {
        extension = "." + extension;
    } else {
        extension = "";
    }
    return extension;
}

function getFeatureString() {
    var selectedCheckboxes = $(htmlIds.featureList + " :checked").parent();

    var tokens = selectedCheckboxes.map(function () {
        return $(this).data().token;
    });

    return tokens.get().join(",");
}
