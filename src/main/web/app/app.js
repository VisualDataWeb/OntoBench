var ui = require("ui");

ui.initialize();

$.getJSON("/features.json")
    .done(function (features) {
              displayFeatures(features);
          });

$.getJSON("/formats.json")
    .done(function (formats) {
              displayFormats(formats);
          });

$("#generate-button").click(function () {
    var url = location.href + "ontology";

    $("#ontology-url").val(url);
    $.ajax({
        url: url,
        dataType: "text"
    }).done(function (ontology) {
        $("#ontology-text").text(ontology.toString());
    });
});

function displayFeatures(features) {
    features.forEach(function (feature) {
        var checkbox = createFeatureCheckbox(feature);
        var container = $("<div>").addClass("item").append(checkbox);
        container.appendTo("#feature-list");
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
        var option = $("<option value='" + format.extension + "'>").text(format.name);
        option.appendTo("#format-list");
    });
}
