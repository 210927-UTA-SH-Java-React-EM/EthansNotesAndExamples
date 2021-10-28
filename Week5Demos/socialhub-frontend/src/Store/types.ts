export interface IUser {
    id: number,
    firstName: string,
    lastName: string,
    email: string,
    username: string,
    password: string
}

export interface IPost {
    id: number,
    username: string,
    content: string,
    likes?: number
}

export type AppState = {
    user: IUser,
    posts: IPost[]
}