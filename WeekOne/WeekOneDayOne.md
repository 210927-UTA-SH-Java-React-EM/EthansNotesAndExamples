# Git Intro

## Git is a version control software

- Keeps track of every change ever made to a software project
- Provides a collaboration tool when working in groups
- We host our git repositories on hosting site like Github/Gitlab

## Central Version Control Software vs Distributed Control Software

- Central: All of the project is stored in one central location that allows for no copies of the master file

- Distributed: Each use has a copy of all versions of the master file locally on their machines that is pushed, pulled, and merged into on repository

## Branching:
a timeline of deviations of version of that master file that don't alter that master file/root branch

## Git Commands:

- `git pull` is a combo of fetch and merge, it will get the latest changes from the remote repo
- `git fetch` will download all history from the remote tracking branch
- `git add` will add files to be commited
    - You can use period (.) after git add (`git add .`) to add all of the changed files to be committed
- `git commit -m "message` will create a commit with a message
    - Please write short but DESCRIPTIVE commits
- `git push` will upload your changes from your local machine to the remote repo
- `git checkout -b name` will create a new branch