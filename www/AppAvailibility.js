var exec = require('cordova/exec');

exports.isAppRunning = function (arg0, success, error) {
    exec(success, error, 'AppAvailibility', 'isAppRunning', [arg0]);
};
exports.nativeToast = function (arg0, success, error) {
                 exec(
                    success, 
                    error, 
                   'AppAvailibility', 
                   'nativeToast', 
                    [arg0]
                    ); 
};
