# Web-Services-Assignments-5

## INSTRUCTIONS

<html>
<body bgcolor="#FFFFFF">
<center>
<h1>CSC435: Homework 5</h1>
</center>
<hr />
<p>Rebuild your entire project from scratch in the <a href="https://grails.org/">Grails</a> framework. Follow the tutorials to acquire a basic understanding, then reimplement your project at all levels: logic, presentation, data store, and services (both producing and consuming).</p>
<p><b>NB: use gorm</b> for the data layer, as opposed to raw SQL this time.</p>
<p>After this homework your project should be designed well (MVC), complete, and working well on top of Grails.</p>
<p>Submit to the Blackboard dropbox your archived (zip or tar.gz) project directory, following the recommended directory structure.</p>
<hr />
</body>
</html>

## My Assignment

Extend previous projects by creating a restful Playlist/Song API, but this time using the Grails framework. 

In dev mode, Grails creats a DB instance, and writes/reads directly from that instead of using the default create-drop mode that Grails v3 sets.

This was chosen because the DB doesn't get removed after shutdown and just updates when needed since the domain classes don't have to be changed.

## Note

When adding something to the in memory database after shutting down, it offsets the new entry's ID by 32. I still haven't found out the reason for this, but it doesn't seem harmful. Otherwise the ID is simply incremented.
