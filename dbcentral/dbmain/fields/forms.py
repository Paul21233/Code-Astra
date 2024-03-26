from django import forms
from .models import Users

class RegistrationForm(forms.ModelForm):
    class Meta:
        model = Users
        fields = ['username', 'email', 'password', 'phone', 'dob']