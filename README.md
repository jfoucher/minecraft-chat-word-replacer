## WordReplacer

This is a simple minecraft bukkit that replaces words in chat by a selection of other words or sentences.
Each replacement can have a probability of being selected as a replacement.

### Installation
Stop your server, copy the downloaded jar file (releases) to your Bukkit plugins directory
edit the config file to choose which words you want to replace
and start your server again.

### Config
The config is a yaml file as follows

```yaml
replacements:
  to_replace:
    replacements:
      - string: "replacement1"
        chance: 10
      - string: "second replacement"
        chance: 1
      - string: "third"
        chance: 1
```

to_replace is the word to replace. It will be replaced by "replacement1" with a 10 in 12 probability,
by "second replacement" with a 1 in 12 probability
and by "third" with a 1 in 12 probability

### Commands
Once your server is running, you can modify the configuration.
To take it into account, you will need to run the command
`/wordreplacer reload` which will reload the config.
You need the permission `wordreplacer.admin` or `wordreplacer.reload` to be able to run the command