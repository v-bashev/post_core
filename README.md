# poST language core
poST language core, based on Xtext framework

# References
- poST to ST translator: https://github.com/v-bashev/post_to_st

# Import poST core project to the Eclipse IDE
1. Download and install [Eclipse](https://eclipse.org/downloads/).
2. From the Eclipse "Help" -> "Eclipse Marketplace..." install / update:\
  2.1. Eclipse Xtext\
  2.2. Eclipse PDE (Plug-in Development Environment)
4. Copy the link to download the repository over the HTTPS protocol:\
   `https://github.com/v-bashev/post_core.git`
5. In an empty Eclipse Workspace open: "File" -> "Import..." -> "Git" -> "Projects from Git" -> "Clone URI".\
   Insert the copied link, click "Next" and follow the prompts.
6. After installing and building the project, open the package: "su.nsk.iae.post/src/su.nsk.iae.post".\
   Right-click on the file "GeneratePoST.mwe2" -> "Run As" -> "MWE2 Workflow".
7. Done.
