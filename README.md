# TapSearch
<h2>DOCUMENTATION</h2><br><br>

<b>Functionalities:</b><br>
 Text indexing and search.<br>


<b>Programming Language used: Java8, Spring-Boot</b><br>

URL: https://tap-search-srv.herokuapp.com/<br>

The "/sample inputs/" folder contains the sample input which was used to test the web app.<br>


<h3>How to Use:</h3><br>
A we go to the link above, it lands us to index page :<br>
 <ul>
     <li>    only "CLEAR" button will be active. Press it so that you can Edit the textArea<br>
     <li>	 Now Enter the paragraphs in the textArea & Enter the word to search and then click on "INDEX" button if you have not indexed those paragraphs initially.
	 <li>    Now Enter on "SEARCH" button to get top paragraphs(here top 10(maximum) paragraphs will be shown). <br>
	 <li> 	 Output paragraphs will be shown on the same textArea but it will be non-editable <br>
	 <li> 	 "To search another word among the indexed paragraphs just enter the word to search, and you will get top paragraphs having that word."<br>
 </ul>



<b>The main search page</b> has these components:<br>
<ul>
       <li>   A "TEXTAREA" to input paragraphs.<br><br>
        <li>  A "INDEX" button, which when clicked, takes paragraphs for indexing.<br>
        <li>  An "SEARCH" button, which when clicked, populates the output on the input textArea.<br>
        <li>  A "CLEAR/EDIT" button, which when clicked, clears the index as well as the textArea.<br>
</ul>


<br>
<h3>RUNNING ON LOCAL SYSTEM</h3> <br>
<ul>
 <li> Clone this repository -  $<i>git clone https://github.com/coder-shivam/TapSearch.git</i>
 <li> Open this project as maven and build the project.
 <li> Deploy or Run the application as Spring-Boot has an embedded server</i> 
</ul>


<b>SNAPSHOTS OF THE APP:</b><br>

 
 <img src="/app-snapshots/Capture_1.png"> </img>
 
 <img src="/app-snapshots/Capture_2.png"> </img>
 <br>
<img src="/app-snapshots/Capture_3.png"> </img>
