# Reactome Documentation Carrousel
With this fantastic widget you can add a great carrousel to show your marvellous work to your magnificent users :D

<img src="img/carrousel.png " align="center" alt="carrousel example">

## How to use the widget?

First add EBI Nexus repository in your pom.xml file

    <repositories>
        ...
        <!-- EBI repo -->
        <repository>
            <id>nexus-ebi-repo</id>
            <name>The EBI internal repository</name>
            <url>http://www.ebi.ac.uk/Tools/maven/repos/content/groups/ebi-repo/</url>
            <releases>
                <enabled>true</enabled>
            </releases>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
        </repository>
        <!-- EBI SNAPSHOT repo -->
        <repository>
            <id>nexus-ebi-snapshot-repo</id>
            <name>The EBI internal snapshot repository</name>
            <url>http://www.ebi.ac.uk/Tools/maven/repos/content/groups/ebi-snapshots/</url>
            <releases>
                <enabled>false</enabled>
            </releases>
            <snapshots>
                <enabled>true</enabled>
            </snapshots>
        </repository>
    </repositories>

Then add the pdbe dependency

    <dependencies>
        ...
        <dependency>
            <groupId>org.reactome.web</groupId>
            <artifactId>carrousel</artifactId>
            <version>1.0.0</version>
        </dependency>
    <dependencies>

Finally you need to inherit the module in your .gwt.xml file

    <inherits name="org.reactome.web.carrousel.Carrousel" />
      
The Carrousel panel can be created as follows and then placed in the right place-holder  
        
    //We assume there is a RESOURCES instance of ClientBundle pointing to the images
    
    List<Slide> slides = new LinkedList<>();
    slides.add(new Slide(RESOURCES.slide01(), "You can import and overlay your data<br>onto pathways by defining custom resources", "white", 18));
    slides.add(new Slide(RESOURCES.slide02(), "A custom resource can be defined by providing a<br>local or network-stored file or a PSICQUIC service", "white", 18));
    slides.add(new Slide(RESOURCES.slide03(), "The simplest way to submit data is in a two-column file<br>(tsv/csv) with the interactors defined in columns 1 and 2", "white", 18));
    slides.add(new Slide(RESOURCES.slide04(), "The extended tuple format offers more options (alias, scores, etc).<br>This information will be displayed and used in the overlay", "white", 18));
    
    CarrouselPanel carrousel = new CarrouselPanel(slides, 600, 400);
    
    RootLayoutPanel.get().add(carrousel);