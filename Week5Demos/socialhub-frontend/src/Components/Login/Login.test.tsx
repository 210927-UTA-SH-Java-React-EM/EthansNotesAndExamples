//Jests describe function creates a test suite for grouping any number of test cases (optional)
import {mount, shallow} from 'enzyme';
import {Login} from './Login';

import {Provider} from 'react-redux';
import configureStore from 'redux-mock-store';

describe('Login test suite', () => {

    const initialState = {
        user: {
            id: 0,
            firstName: '',
            lastName: '',
            email: '',
            username: '',
            password: ''
        },
        posts: []
    }

    const mockStore = configureStore();
    let store;

    //Create our first test function
    it('Login renders successfully', () => {
        store = mockStore(initialState);
        const wrapper = shallow(<Provider store={store}><Login /></Provider>)
        expect(wrapper).toBeTruthy();
    });

    //We can look for specific elements on the page that are supposed to be there
    it('Renders the login header', () => {
        store = mockStore(initialState);
        const wrapper = mount(<Provider store={store}><Login /></Provider>);
        const expectedHeader = <h1 className="login-h1">Welcome to Socialhub!</h1>
        expect(wrapper.contains(expectedHeader)).toEqual(true);
    });

    it('Username and password fields start empty', () => {
        store = mockStore(initialState);
        const wrapper = mount(<Provider store={store}><Login /></Provider>);

        let usernameInputWrapper = wrapper.find('#username');
        let passwordInputWrapper = wrapper.find('#password');

        expect(usernameInputWrapper.text()).toBe('');
        expect(passwordInputWrapper.text()).toBe('');
    });

});