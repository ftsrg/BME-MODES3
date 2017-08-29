import {app, Browser, BrowserWindow} from 'electron';
import {enableLiveReload} from 'electron-compile';
import path from 'path';
import url from 'url';

import Application from './app/app';

let window;

app.on('ready', () => {
  enableLiveReload();

  window = new BrowserWindow({width: 800, height: 480});
  window.loadURL(url.format({
    pathname: path.join(__dirname, 'static/index.html'),
    protocol: 'file:',
    slashes: true
  }));

  window.openDevTools({
    mode: 'undocked'
  });

  window.on('closed', () => {
    window = null
  });
});

// Quit when all windows are closed.
app.on('window-all-closed', () => {
  app.quit()
});
