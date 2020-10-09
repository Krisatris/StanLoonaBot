import discord
import sys

class StanLoonaBot(discord.Client):
    async def on_ready(self):
        print('Logged on as {0}!'.format(self.user))

    async def on_message(self, message):
        if message.author == self.user:
            return
        
        print('Message from {0.author}: {0.content}'.format(message))
        
        if message.content.startswith("!stan loona"):
            await message.channel.send('stan loona')

        if message.content.startswith("!play"):
            connected = message.author.voice
            if connected:
                await connected.channel.connect()
            else:
                await message.channel.send("You're not in a voice channel!")

        if message.content.startswith("!leave"):
            server = message.guild.voice_client
            await server.disconnect()

client = StanLoonaBot()
fin = open("token.txt", 'r')
token = fin.read()
fin.close()
client.run(token)
