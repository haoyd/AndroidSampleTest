var ZmdjComApi = {};
var ZmdjCom = {};
ZmdjCom.Kernel = (function () {
    if (ZmdjCom.Bridge) {
        return
    }
    var responseCallbacks = {};
    var uniqueId = 1;

    function init(messageHandler) {
        if (ZmdjCom.Bridge._messageHandler) {
            return
        }
        ZmdjCom.Bridge._messageHandler = messageHandler
    }

    function _jsGetData(message, responseCallback) {
        if (responseCallback && typeof(responseCallback) === "function") {
            var callbackId = "ZmdjCom_" + (uniqueId++) + "_" + new Date().getTime();
            responseCallbacks[callbackId] = responseCallback;
            message["callbackId"] = callbackId
        }

        ZmdjNaCom.jsGetData(JSON.stringify(message))
    }

    function _naGetData(messageJSON) {
        var message;
        console.log(messageJSON);
        if (typeof(messageJSON) == "object") {
            message = messageJSON
        } else {
            message = JSON.parse(messageJSON)
        }
        console.log(JSON.stringify(message));
        if (message.responseId && message.responseId.length > 0) {
            var responseCallback = responseCallbacks[message.responseId];
            if (!responseCallback) {
                return
            }
            responseCallback(message.data);
            delete responseCallbacks[message.responseId]
        } else {
            var resdata;
            var handler = ZmdjCom.Bridge._messageHandler;
            console.log(message.type);
            if (message.type && message.type.length > 0) {
                handler = ZmdjComApi[message.type]
            }
            console.log(handler);
            try {
                resdata = handler(message.data);
                if (message.callbackId && message.callbackId.length > 0) {
                    console.log(resdata);
                    var callbackResponseId = message.callbackId;
                    console.log(callbackResponseId);
                    ZmdjNaCom.jsGetData(JSON.stringify({responseId: callbackResponseId, data: resdata}))
                }
            } catch (exception) {
                if (typeof console != "undefined") {
                    console.log("ZmdjCom.Bridge: WARNING: javascript handler threw.", message, exception)
                }
                return
            }
        }
    }

    ZmdjCom.Bridge = {init: init, jsGetData: _jsGetData, naGetData: _naGetData};
    var bridge = ZmdjCom.Bridge;
    bridge.init(function (message, responseCallback) {
    })
})();