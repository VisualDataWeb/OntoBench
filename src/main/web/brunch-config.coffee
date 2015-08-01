# See http://brunch.io/#documentation for docs.
exports.config =
  notifications: false
  modules:
    autoRequire:
      "app.js": ["app"]
  paths:
    public: "../../../static"
  files:
    javascripts:
      joinTo:
        "app.js": /app/
        "vendor.js": /^(vendor|bower_components)/
    stylesheets:
      joinTo:
        "app.css": /^(vendor|bower_components|app)/
  plugins:
    babel:
      ignore: [/(vendor|bower_components)/]
    assetsmanager:
      copyTo:
        "themes/default": ["bower_components/semantic-ui/dist/themes/default/*"]
