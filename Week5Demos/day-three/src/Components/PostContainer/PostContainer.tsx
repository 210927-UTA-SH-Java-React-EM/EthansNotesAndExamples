import React, {useState, useEffect} from 'react';

import {Post} from '../Post/Post';

export const PostContainer:React.FC<any> = (data:any) => {

    //Define our state
    let [posts, setPosts] = useState([]);

    //Use useEffect to get the posts on page load
    useEffect(() => {
        setPosts(data.data);
    }, [posts]);

    //Inside of our return, we are going to loop through our posts array, and map each individual
    //post to a Post component, and display them in the post container
    return(
        <div>
            {
                posts.map((post:any) => {
                    return <Post {...post} key={post.postId} />
                })
            }
        </div>
    )

}
