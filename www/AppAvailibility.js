var exec = require('cordova/exec');

exports.isAppRunning = function (arg0, success, error) {
    exec(success, error, 'AppAvailibility', 'isAppRunning', [arg0]);
};
