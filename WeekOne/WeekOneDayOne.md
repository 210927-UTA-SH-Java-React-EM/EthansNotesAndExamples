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

Git cheat sheet:

https://training.github.com/downloads/github-git-cheat-sheet.pdf

# SDLC (Software Development Lifecycle):
Outlines the process to plan, create, test, and deploy information systems and appliations

## SDLC Follows these 7 general steps:
1. Requirements Phase
2. Analysis Phase
3. Design Phase
4. Development Phase
5. Testing Phase
6. Integration and Deployment Phase
7. Maintenance Phase

There are are two main approaches to SDLC currently:
- Waterfall
- Agile

## Waterfall

Waterfall is a linear approach, as you finish one stop you move onto the next, there is no going back

## Typical Timeline of Waterfall:

- Requirements: 2-4 weeks
- Planning: 2-4 weeks
- Design: 1-4 months
- Implementation: 6-12 months+
- Testing: 6 months, but actually ongoing
- Deployment: 1-3 weeks
- Maintenance: lifetime of the application

Advantages of Waterfall

- Easy to manage workflow
- Well suited for small teams, or short term projects, that will not require and requirement chanfes
- Generally results in faster devilery of product
- Process and results can easily documented
- Easy to adapt to shifting teams since the steps are clearly laid out

Disadvantages of Waterfall:
- Very inflexible and inefficient
- Not ideal for large teams projects
- Testing does not begin until development is complete

## Agile

Agile is an iterative approach, go through every step of the SDLC in 2 - 4 week sprints

Agile is becoming the more widely accepted and utilized method of SDLC because of its core values
- Individuals and Interactions over processes and tools
- Working Software over comprehensive documentation
- Customer collaboration over contract negotiation
- Responding to change over following a plan

## Advantages vs Disadvantages

Advantages of Agile:
- Client colaboration is generally regarded as positive
- Agile team cultures tend to stay more self-organized and motivated
- Overall quality of prodices is usually higher due to the iterative approach
- Less risk in development process due incremental nature of development

Disadavantanges of Agile:
- Not as useful for small development project
- Higher costs associated with the Agile workflow
- Development time can bloat if managed poorly, or requirements are not clear
- Requires more experienced memebers during the planning and management of projects

# Agile/Scrum Concepts

Scrum is the simplest Agile framework, it enforces ceremonies lead by a lead who ensures the team is following Scrum practices

![scrum](scrum_iteration.jpg)

## Scrum Artifacts

- Product Owner: holds authority over project, a representative of the client/customer
- Scrum Master: the person who mediates all the meetings, and goes between client and team
- Project Backlog: holds all the current requirements for the project
- Sprint Backlog: requires that are to be completed in the current sprint
- User Story: an individual feature/requirement
- Epic: a group of related features that is broken down into multiple user stories
- Spring: a brief period of development, (between 2 and 4 weeks). which generally cumulates in a release of realated features
- Velocity: the sum of story points of all the user stories completed that week

## Story Pointing

Story pointing allows teams to keep track of the progress (velocity) of their sprint/project, and create burndown charts

Burndown Charts: chart the amount of story points that been completed each day, vs the number of points remaining

![burndown](burndown.PNG)

When assigning story points, it should be a team discussion, that includes consideration of Risk, Complexity, and Repetition of the user story

It is also recommended to use a number fib sequence:
- 1: "trivial"
- 2: "easy"
- 3: "medium"
- 5: "difficult"

## Scrum Ceremonies:
meetings used during the life cylce of the sprint in a project

Sprint Planning:
- Include the entire dev team, scrum master, product owner
- Happen before every sprint
- Determine the scope, goals, and metrics of the sprint

Daily Standup/Scrum:
- This is a daily meeting lead by the scrum master
- Takes aprox. 15 minutes
- Everyone tells what they are working on, what they are stuck on, and their goals for the day

Sprint Review:
- Everyone is invited to this meeting
- Review what the team accomplished at the end of a sprint
- Gain feedback

Sprint Retro:
- Scrum master reviews the metric, and assess any ineffiencies
- Plan to make improvemtents as a team