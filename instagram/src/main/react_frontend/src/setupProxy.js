// src/main/frontend/src/setProxy.js

// src\main\react_frontend\src\setupProxy.js

// src\main\react_frontend\src\utils\setupProxy.js
const { createProxyMiddleware } = require('http-proxy-middleware');

module.exports = function(app) {
  app.use(
    '/instagramAPI',
    createProxyMiddleware({
      target: 'http://localhost:8080',	//서버 URL or localhost:설정한포트번호
      changeOrigin: true,
    })
  );
};