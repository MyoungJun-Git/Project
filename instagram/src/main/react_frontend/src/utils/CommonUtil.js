import axios from 'axios';

//Null or Empty
export function isNullOrEmpty(i_value) {
    if (i_value === ""
        || i_value === null
        || i_value === undefined
        || (i_value !== null && typeof i_value === "object" && !Object.keys(i_value).length)) {
        return true;
    } else {
        return false;
    }
}

//async false
export async function getAsncAxios(i_type, i_requestURL, i_params, i_callbackFunction) {
    const isType = isNullOrEmpty(i_type)
        , isRequestURL = isNullOrEmpty(i_requestURL)
        , isParams = isNullOrEmpty(i_params)
        , isCallbackFunction = isNullOrEmpty(i_callbackFunction);

    if (false === isType
        && false === isRequestURL) {
        if ('GET' === i_type) {
            //GET
            await axios.get(i_requestURL)
                .then((res) => {
                    if (false === isCallbackFunction) {
                        i_callbackFunction(res);
                    } else {;}
                })
                .catch((err) => {
                    i_callbackFunction(err);
                });
        } else {
            //POST
            await axios.post(i_requestURL, JSON.stringify(false === isParams ? i_params : '{}'), {
                    headers: {
                        "Content-Type": 'application/json',
                    }
                })
                .then((res) => {
                    if (false === isCallbackFunction) {
                        i_callbackFunction(res);
                    } else {;}
                })
                .catch((err) => {
                    console.log(err);
                    i_callbackFunction(err);
                });
        }
    } else {
        console.log('Type : ' + isType);
        console.log('RequestURL : ' + isRequestURL);
    }
}

//async true
export async function getAxios(i_type, i_requestURL, i_params, i_callbackFunction) {
    const isType = isNullOrEmpty(i_type)
        , isRequestURL = isNullOrEmpty(i_requestURL)
        , isParams = isNullOrEmpty(i_params)
        , isCallbackFunction = isNullOrEmpty(i_callbackFunction);

    if (false === isType
        && false === isRequestURL) {
        if ('GET' === i_type) {
            //GET
            axios.get(i_requestURL)
                .then((res) => {
                    if (false === isCallbackFunction) {
                        i_callbackFunction(res);
                    } else {;}
                })
                .catch((err) => {
                    console.log(err);
                    i_callbackFunction(err);
                });
        } else {
            //POST
            axios.post(i_requestURL, JSON.stringify(false === isParams ? i_params : '{}'), {
                    headers: {
                        "Content-Type": 'application/json',
                    }
                })
                .then((res) => {
                    if (false === isCallbackFunction) {
                        i_callbackFunction(res);
                    } else {;}
                })
                .catch((err) => {
                    console.log(err);
                    i_callbackFunction(err);
                });
        }
    } else {
        console.log('Type : ' + isType);
        console.log('RequestURL : ' + isRequestURL);
    }
}