from django.urls import path
from .views import register
from django.views.generic import TemplateView
from django.conf import settings
from django.conf.urls.static import static

urlpatterns = [
    path('register/', TemplateView.as_view(template_name='../../../src/resources/Fxml/register.fxml'), name='register'),
]

if settings.DEBUG:
    urlpatterns += static(settings.STATIC_URL, document_root=settings.STATIC_ROOT)
