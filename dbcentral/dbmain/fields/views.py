from django.shortcuts import render, redirect
from django.contrib.auth.hashers import make_password
from .forms import RegistrationForm
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt

def register(request):
    if request.method == 'POST':
        form = RegistrationForm(request.POST)
        if form.is_valid():
            password = form.cleaned_data['password']
            hashed_pass = make_password(password)
            form.instance.password = hashed_pass
            form.save()
            return JsonResponse({'success':True})
        else:
            return JsonResponse({'errors': form.errors}, status = 400)
    else:
        form = RegistrationForm()
    return JsonResponse({'errors': 'Method not allowed'}, status=405)
