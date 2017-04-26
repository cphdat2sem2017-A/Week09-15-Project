## Agile Development 
### Principles
Agile software development is based on the agile manifesto [http://agilemanifesto.org/] and a number of underlying principles agile principle, hereunder
- Simplicity--the art of maximizing the amount of work not done--is essential
- The best architectures, requirements, and designs emerge from self-organizing teams

So agile teams do not follow detailed enterprise design guidelines to make "a big design up front" in the beginning of a project.The simplicity principle means, that the team will do what is needed and asked for, but no more. This will maximize the value created for the investment made to date. Developers will take small simple steps to their goal and mitigate failures as they happen.  

### Why?
There is no reason to spend a lot of time on building a detailed design as you might not really know what you are doing early on in a project. Non-agile developers will often tell you to reduce risk by modeling everything in detail, but if you step back and think about it for a minute, this actually increases your risk. Does it really make sense to do a lot of detailed modeling when you don't really know what you're doing? Think about modeling a full database in the very first Scrum sprint. Probably not something that you really have enough knowledge to do well.

Most often you do not know whether a design solution is going to work, until you have proved it with code. Therefore the best design evolve over time, instead of being defined up front.

### How?
 - why?
 - when to spend time on design?
 - how
 
## System Design 
### Layers
Decomposing a system into layers is the most commonly used software architectural style. Most often a three layered architecture is used, where each layer can only us the adjacent lower level. 
We typically have:
- UI layer which represents the presentation logic, i.e. handling the interaction between the user and the software. The primary responsibilties of this layer are to display information to the user and to interpret commands from the user into actions upon the domain model layer.
- Data source layer which contains the logic to communicate with other systems that carry out tasks on behalf of the application. These can be databases, mail servers, other applications etc.
- Domain model layer which contains the business logic. This is the work that the application needs to do for the domain that you are working with. This involves for example calculations based on inputs and stored data, validation of the data from the presentation layer, and finding out which data source logic to dispatch, depending on commands received from the presentation.

<picture 3 layer architecture>

- why?
- how?

## Object Design
Architecture is more abstract than design and has focus on decomposing a system into smaller modules (subsystems or layers) whereas object design is more about how a specify module/subsystem/layer is implemented.
- why and how ?
- MVC
- Front Controller
- Command pattern

## UML
