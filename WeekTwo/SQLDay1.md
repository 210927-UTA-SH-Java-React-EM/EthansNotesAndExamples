# Amazon Web Services Intro (AWS):
Cloud computing services that are provided by Amazon
- providing a simple way to access servers, storage, databases, and more

## Advantages of Cloud Computing:
- Pay as you go
- Lower pay as you go prices due economies of scale
- Automatically scale up or down
- Easily and quickly alocate resources
- Less startup cost
- Deploy you application globally in seconds

## Cloud Computing Models

Infrastructure as a Service (IaaS):
- a self-service model for managing remote data center infrastructures

Platform as a Service (PaaS):
- allows organizations to build, run and manage application without IT infrastructure

Software as a Service (SaaS);
- reaplces tradional on-device software with software that is licensed on a subscription basis

AWS follows pay as you go, with the free tier options

AWS is also available in over 24 regions, with 77 availibility zones

## AWS Regions:
geographic location with a collection of availability zones

## Availability Zone:
A physical data center inside of a region

# AWS RDS (Relational Data Service):
a service that makes it easier to setup, operate, and scale a relational database in the AWS cloud
- cost-efficient, resizable capacity for stand relational databases
- manages database administration tasks for you

# AWS EC2 (Elastic Compute Cloud):
service that provides secure resizable compute capacity in the cloud
- designed to make web-scale cloud computing easier for developers
- virtual computing environment (aka your "server")
- preconfigured environment templates, called Amazon Machine Images(AMI)
    - Completely preconfiguted os images that have software preinstalled to help you host your application
- instances are configure
- built in security like firewals

The firewalls are known as **security groups**
- These are set at the instance level, it holds a series of white listed ips are explicitly allowed to connect to the server

## Elastic Block Storage (EBS):
provides block level storage volumes for your EC2 instances
- If you need extra storage on your EC2, you can attach an EBS Volume

# Unix
a family of Operating Systems which derive from an OS built in the 1970's at Bell Labs by AT&T
- it is open sourced, anyone can access the source code/contribute
- first stable distribution was Linux, other include MacOS, and RedHat
- RedHat is no open source, but it is the most popular version of Linux

# Unix File System

The file system in Linux is comprised of Directories, generally described as a tree structure, with the Root Directory being the very top level, this is denoted by the `/` character

The home directory is where the users personal files are typically stored, this directory is denoted the `~` character

# Unix Commands
you use commands to navigate the file system, and perform tasks on a Unix system

Some commands can take arguments and flags
- Arugments take a form of a string, and they go after the command you would like to execute
- Flags typically do before arugments, and they are preded by either a `-` if you are using the shorthand, or a double `--` if you are using the long hand

## The Most Important Command
`man` - The manual command will print to the terminal the manual for using a particular command. If you are unsure what flags or arguments a command takes, you simple type `man command`. For example if you wished to see the manual for the copy command, you would type `man cp`

## Unix Command Cheat Sheet:

https://www.guru99.com/linux-commands-cheat-sheet.html

# Enviorment Variables:
a variable that is set and able to be used from anywhere on your system
- You are able to set these using the `export` command, either in your terminal or in the startup script ~/.bashrc
- Variables assigned with `export` will be deleted on shell restart
- Variables assigned in the startup script will be persisted
- Use `unset` command to remove an environment variable

# File Permissions

File permissions in Unix are important because everything in Unix id considered a file, even directories

File permissions are broken down into three different groupd, and you can set these groups individually,
- File owner
- Group
- Other

To change these file permissions you will use the `chmod` command

Each of the three groups can be assign a number between 0 and 7, this number is a binary representation of which permissions are allowed for the file
- Binary 1 -> 001 means execution is allowed
- Binary 2 -> 010 means writing is allowed
- Binary 4 -> 100 means that reading is allowed
- You can combine these three different ways to get any combination of execute, write, and read

The syntax for the chmod command goes as follows
`chmod <owner><group><other> [file]`

chmod 750 file.txt -> would allow all permission to the owner, read and execute to the group, and nothing to others

There is another, less intuitive that uses letters instead of numbers, the letters u for owner, g for group, o for other, to add or remove permissions you would use the + or - signs, you want exact permissions for one of the groups you can use the = sign. The letters e can be used to add or execute, r for read, w for write

chmod a+rwx hello.txt -> gives everyone all permissions

chmod o-w hello.txt -> remove write access from other

chmod g+w -> gives the group write permissions

# Package Managers

In order to install software on Unix based OS you generally use a Package Manager. There are several available, here are some popular ones:

RPM: is the Redhat Package Manager, is a package manager that was created for the Red Hat Linux OS, used with other distributions of Linux

APT: Advanted Package Tool, is a package manager used on many Linux Distributions. It allows you to retrieve, configure, and install/uninstall packages

YUM: Yellow Dog Updater, is package management utility for machine running RPM, you Amazom EC2 will install YUM for you on initialization
- You will most likely use yum commands such as update, install, and remove

# Command-Line Text Editors

Command line text editor allows you write/modify files in the command line

Editors such vi, vim, or nano should be built into your linux distribution

Nano is the easiest to control, here are some guides to two of the most popular command line text editors:

Nano: https://www.howtogeek.com/howto/42980/the-beginners-guide-to-nano-the-linux-command-line-text-editor/

Vim: https://www.linux.com/training-tutorials/vim-101-beginners-guide-vim/

# AWS S3 (Simple Storage Service):
object storage service that offers industry-leading scalability, data availability, security, and performance
- Store and retrieve almost any amount of data from anywhere

S3 uses what is called object storage, where each object is stored in its own bucket
- You can access these buckets via dedicated URL's given by amazon
- You can use there buckets to backup files, host static websites, host media, host applications
- You can access, and add items to bucket with API's which is very useful