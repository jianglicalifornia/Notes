Graphviz 
==============

http://www.graphviz.org/

##Common commands

Output ps file: `dot -Tps filename.dot -o outfile.ps`
Output png file: `dot -Tpng input.dot > output.png`

[CommandsReference](http://www.graphviz.org/doc/info/command.html)
[DotGuide](http://www.graphviz.org/pdf/dotguide.pdf)


##Tips
** Manule placement **

```
xxx [
    label = xxx
    pos = "0,0!"
]

yyy [
    label = yyy
    pos = "10,10!"
]
```

You will also have to specify neato or fdp layout engine, so that dot command-line would be (for fdp): `dot -Kfdp -n -Tpng -o sample.png sample.dot`




- - -


