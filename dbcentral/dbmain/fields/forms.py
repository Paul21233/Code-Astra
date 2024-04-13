from django import forms
from .models import Users


class RegistrationForm(forms.ModelForm):
    confirmPassword = forms.CharField(widget=forms.PasswordInput())

    class Meta:
        model = Users
        fields = ['username', 'email', 'password', 'confirmPassword', 'phone', 'dob']

    def clean(self):
        cleaned_data = super().clean()
        password = cleaned_data.get('password')
        confirmPassword = cleaned_data.get('confirmPassword')

        if password and confirmPassword and password != confirmPassword:
            raise forms.ValidationError("Passwords do not match.")

        return cleaned_data
