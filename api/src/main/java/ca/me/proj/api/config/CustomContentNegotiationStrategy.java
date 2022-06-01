package ca.me.proj.api.config;

/**
 * This class is used to override the default way Spring handles 'Accept' headers, since we want to
 * provide XML only for application/xml explicitely, NOT browser requests of the type "Accept:
 * text/html, ..., application/xml"
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.accept.ContentNegotiationStrategy;
import org.springframework.web.context.request.NativeWebRequest;

public class CustomContentNegotiationStrategy implements ContentNegotiationStrategy {
    @Override
    public List<MediaType> resolveMediaTypes(NativeWebRequest nativeWebRequest)
            throws HttpMediaTypeNotAcceptableException {
        MediaType DEFAULT_MEDIA_TYPE = MediaType.APPLICATION_JSON;

        Set<MediaType> mediaTypes = new HashSet<>();
        String acceptHeader = nativeWebRequest.getHeader(HttpHeaders.ACCEPT);
        if (acceptHeader == null || isBrowserRequest(acceptHeader)
                || acceptHeader.contains(MediaType.ALL_VALUE))
            mediaTypes.add(MediaType.APPLICATION_JSON);
        else if (acceptHeader.contains(MediaType.APPLICATION_XML_VALUE))
            mediaTypes.add(MediaType.APPLICATION_XML);
        else
            mediaTypes.add(DEFAULT_MEDIA_TYPE);
        return new ArrayList<>(mediaTypes);
    }

    // basic heuristic to see if the request comes from a browser
    private boolean isBrowserRequest(String acceptHeader) {
        return acceptHeader.startsWith(MediaType.TEXT_HTML_VALUE)
                && acceptHeader.contains(MediaType.APPLICATION_XML_VALUE);
    }
}
