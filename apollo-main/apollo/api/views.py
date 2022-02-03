from django.http import HttpResponse, JsonResponse
from django.views.decorators.csrf import csrf_exempt


def ping(request):
    return HttpResponse('pong')


@csrf_exempt
def editor(request):
    data = []
    for i in range(64):
        n = hex(i * 16)[2:].zfill(8)
        line = f"{n}:\t00\t00\t00\t00\t00\t00\t00\t\t00\t00\t00\t00\t00\t00\t00\t00\t\t................"
        data.append(line)
    return JsonResponse({'contents': "\n".join(data)})
