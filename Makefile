# makefile for GraphExperiment
# Nathan Wells
# 13 April 2023
JAVAC=/usr/bin/javac
JAVA = /usr/bin/java
.SUFFIXES: .java .class
SRCDIR=src
BINDIR=bin

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(BINDIR) -sourcepath $(SRCDIR) $<

CLASSES= Vertex.class Edge.class GraphException.class Path.class Graph.class Data.class GraphExperiment.class
		
CLASS_FILES=$(CLASSES:%.class=$(BINDIR)/%.class)

default: $(CLASS_FILES)

clean:
	rm $(BINDIR)/*.class

run:
	$(JAVA) -cp bin GraphExperiment
