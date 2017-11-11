const webpack = require("webpack");
const path = require("path");

module.exports = {
    entry: {
        "main": "./src/js/main",
        "write": "./src/js/write",
        "admin": "./src/js/admin"
    },
    output: {
        filename: "[name].js",
        path: path.resolve(__dirname, "build")
    },
    plugins: [
        new webpack.HotModuleReplacementPlugin()
    ],
    devServer: {
        hot: true,
        inline: true,
        host: 'localhost',
        disableHostCheck: true,
        port: 3000,
        open: false,
        openPage: 'html/#/',
        contentBase: "src",
        watchOptions: {
            aggregateTimeout: 300,
            poll: 1000
        }
    }
};
