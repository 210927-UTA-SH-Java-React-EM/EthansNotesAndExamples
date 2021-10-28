//This is our central/root reducer
import { combineReducers } from "redux";
//We will create these next
import {userReducer} from './UserReducer';
import {postReducer} from './PostReducer';

export default combineReducers({
    user: userReducer,
    posts: postReducer
});