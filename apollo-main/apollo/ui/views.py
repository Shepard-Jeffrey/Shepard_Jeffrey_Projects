from django.contrib.auth import authenticate, login as auth_login, logout as auth_logout
from django.contrib.auth.decorators import login_required
from django.shortcuts import redirect, render


@login_required
def index(request):
    files = [
        ('banned-ips.json', 2),
        ('banned-players.json', 2),
        ('bukkit.yml', 1137),
        ('cache', 91996097),
        ('commands.yml', 598),
        ('eula.txt', 10),
        ('help.yml', 2576),
        ('logs', 195861),
        ('minecraft_server.1.16.4.jar', 46987530),
        ('ops.json', 543),
        ('paper.yml', 7522),
        ('permissions.yml', 0),
        ('plugins', 8528),
        ('server.properties', 1097),
        ('spigot.yml', 4367),
        ('usercache.json', 430),
        ('version_history.json', 47),
        ('whitelist.json', 2),
        ('world', 41846947),
        ('world_nether', 4069228),
        ('world_the_end', 17027097),
    ]
    return render(request, 'ui/index.html', {'files': files})


def login(request):
    username = request.POST.get('username')
    password = request.POST.get('password')
    user = authenticate(request, username=username, password=password)
    if user:
        auth_login(request, user)
        return redirect('/')
    else:
        return render(request, 'ui/login.html')


def logout(request):
    auth_logout(request)
    return redirect('/login')
