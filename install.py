import os

# variables for folders
data = "data"
plugin = "PLUGIN"

# create folders
if not os.path.isdir(data):
    os.makedirs(data)
if not os.path.isdir(plugin):
    os.makedirs(plugin)
