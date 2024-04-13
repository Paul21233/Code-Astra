from django.shortcuts import render, redirect
from django.contrib.auth.hashers import make_password
from .forms import RegistrationForm
from django.http import JsonResponse
from django.views.decorators.csrf import csrf_exempt


# @csrf_exempt  # Temporarily disable CSRF protection for cross-origin requests
def register(request):
    if request.method == 'POST':
        # Accessing data from POST request body
        data = request.POST.dict()  # Convert POST data to a dictionary

        # Creating a form instance using received data
        form = RegistrationForm(data)

        if form.is_valid():
            hashed_password = data['hashed_password']  # Access the already hashed password
            form.instance.password = hashed_password
            print("Data is going to be saved")
            form.save()
            print("Data is saved successfully")
            return JsonResponse({'success': True})
        else:
            return JsonResponse({'errors': form.errors}, status=400)
    else:
        # Handling GET requests or other unsupported methods
        return JsonResponse({'errors': 'Method not allowed'}, status=405)

