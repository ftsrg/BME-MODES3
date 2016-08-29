import React from 'react';
import { render } from 'react-dom';
import { createStore, Provider} from 'redux';

import { Router, Route, Link, browserHistory } from 'react-router'

import dashboardReducer from './reducers/DashboardReducer';
import Dashboard from './containers/Dashboard';

let store = createStore(dashboardReducer);

ReactDOM.render(
	<Provider store={store}>
		<Dashboard />
	</Provider>,
	document.getE
)