#How to save Google Web Open Font Format files locally and use them to style your page

For a Spring MVC app, create a new folder "fonts" in your "static" folder. I.e. static/fonts

1) Go to fonts.google.com. Click the red plus-sign icon to select the fonts you want to download.

2) Expand the Familiest Selected tab at the bottom of the viewport. Click @IMPORT to display code for embedding in your style sheet. Copy the code to embed your font, and consider copying the example CSS code for specifying the font in your style sheet.

Example embed code:
<style>
@import url('https://fonts.googleapis.com/css?family=Barlow|Roboto|Spectral+SC');
</style>

Example CSS code:
    font-family: 'Spectral SC', serif;
    font-family: 'Roboto', sans-serif;
    font-family: 'Barlow', sans-serif;

3) From the Embed code, copy the Google-generated url beginning https:// and go to this URL in your browser.

Example:
https://fonts.googleapis.com/css?family=Barlow|Roboto|Spectral+SC

4) You should see a CSS-format style-sheet listing many @font-face definitions for various character sets for your selected fonts, such as latin, cyrillic, greek. We will save the latin and latin-ext sets, if available.

example result:

/* latin-ext */
@font-face {
  font-family: 'Barlow';
  font-style: normal;
  font-weight: 400;
  src: local('Barlow Regular'), local('Barlow-Regular'), url(https://fonts.gstatic.com/s/barlow/v1/SCyUdhaPYx6RJd17dIjx7vesZW2xOQ-xsNqO47m55DA.woff2) format('woff2');
  unicode-range: U+0100-024F, U+1E00-1EFF, U+20A0-20AB, U+20AD-20CF, U+2C60-2C7F, U+A720-A7FF;
}
/* latin */
@font-face {
  font-family: 'Barlow';
  font-style: normal;
  font-weight: 400;
  src: local('Barlow Regular'), local('Barlow-Regular'), url(https://fonts.gstatic.com/s/barlow/v1/m4mkzFgzyAU93qx0-DUx_Q.woff2) format('woff2');
  unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02C6, U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2212, U+2215;
}
/* cyrillic-ext */
@font-face {
  font-family: 'Roboto';
  font-style: normal;
  font-weight: 400;
  src: local('Roboto'), local('Roboto-Regular'), url(https://fonts.gstatic.com/s/roboto/v18/ek4gzZ-GeXAPcSbHtCeQI_esZW2xOQ-xsNqO47m55DA.woff2) format('woff2');
  unicode-range: U+0460-052F, U+20B4, U+2DE0-2DFF, U+A640-A69F;
}

5) For each font and character set, locate and copy its URL in the CSS code. In a new tab, enter this url in your browser. You will be prompted to save a file. Keep the .woof2 file extension, but give the file a descriptive name based on its font-family name and its character set.

example:
barlow-regular-latin-ext.woff2

6) Copy the CSS code for your font into your style.css. Replace the value for url with the path and file name. Remember for a Spring app, the initial reference folder is static. If your font file is saved in the fonts folder in static, your reference (aka starting) folder is always static.

Example:
/* latin-ext */
@font-face {
  font-family: 'Barlow';
  font-style: normal;
  font-weight: 400;
  src: local('Barlow Regular'), local('Barlow-Regular'), url(./fonts/barlow-regular-latin-ext.woff2) format('woff2');
  unicode-range: U+0100-024F, U+1E00-1EFF, U+20A0-20AB, U+20AD-20CF, U+2C60-2C7F, U+A720-A7FF;
}

7) You should now be able to assign this font to selected elements in your style sheet by referencing its font-family value defined in the @font-face annotation.
