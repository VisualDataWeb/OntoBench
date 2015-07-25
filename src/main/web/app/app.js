$.getJSON("/features.json")
    .done(function (features) {
              displayFeatures(features);
          });


function displayFeatures(features) {
    features.forEach(function (feature) {
        var checkbox = createFeatureCheckbox(feature);
        var container = $("<div>").addClass("item").append(checkbox);
        container.appendTo("#feature-list");
    });
}

function createFeatureCheckbox(feature) {
    var name = feature.token + "-feature";

    var container = $("<div>").data(feature).addClass("ui checkbox");
    $("<input type='checkbox' id='" + name + "'>").appendTo(container);
    $("<label>").attr("for", name).text(feature.name).appendTo(container);
    return container;
}
