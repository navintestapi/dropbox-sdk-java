/* DO NOT EDIT */
/* This file was generated from files.stone */

package com.dropbox.core.v2.files;

import com.dropbox.core.stone.StoneSerializers;
import com.dropbox.core.stone.StructSerializer;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;

import java.io.IOException;

class DownloadArg {
    // struct DownloadArg

    protected final String path;
    protected final String rev;

    /**
     *
     * @param path  The path of the file to download. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     * @param rev  Deprecated. Please specify revision in the {@code path}
     *     argument to {@link DbxUserFilesRequests#download(String)} instead.
     *     Must have length of at least 9 and match pattern "{@code [0-9a-f]+}".
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DownloadArg(String path, String rev) {
        if (path == null) {
            throw new IllegalArgumentException("Required value for 'path' is null");
        }
        if (!java.util.regex.Pattern.matches("(/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)", path)) {
            throw new IllegalArgumentException("String 'path' does not match pattern");
        }
        this.path = path;
        if (rev != null) {
            if (rev.length() < 9) {
                throw new IllegalArgumentException("String 'rev' is shorter than 9");
            }
            if (!java.util.regex.Pattern.matches("[0-9a-f]+", rev)) {
                throw new IllegalArgumentException("String 'rev' does not match pattern");
            }
        }
        this.rev = rev;
    }

    /**
     * The default values for unset fields will be used.
     *
     * @param path  The path of the file to download. Must match pattern "{@code
     *     (/(.|[\\r\\n])*|id:.*)|(rev:[0-9a-f]{9,})|(ns:[0-9]+(/.*)?)}" and not
     *     be {@code null}.
     *
     * @throws IllegalArgumentException  If any argument does not meet its
     *     preconditions.
     */
    public DownloadArg(String path) {
        this(path, null);
    }

    /**
     * The path of the file to download.
     *
     * @return value for this field, never {@code null}.
     */
    public String getPath() {
        return path;
    }

    /**
     * Deprecated. Please specify revision in the {@code path} argument to
     * {@link DbxUserFilesRequests#download(String)} instead
     *
     * @return value for this field, or {@code null} if not present.
     */
    public String getRev() {
        return rev;
    }

    @Override
    public int hashCode() {
        int hash = java.util.Arrays.hashCode(new Object [] {
            path,
            rev
        });
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        // be careful with inheritance
        else if (obj.getClass().equals(this.getClass())) {
            DownloadArg other = (DownloadArg) obj;
            return ((this.path == other.path) || (this.path.equals(other.path)))
                && ((this.rev == other.rev) || (this.rev != null && this.rev.equals(other.rev)))
                ;
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return Serializer.INSTANCE.serialize(this, false);
    }

    /**
     * Returns a String representation of this object formatted for easier
     * readability.
     *
     * <p> The returned String may contain newlines. </p>
     *
     * @return Formatted, multiline String representation of this object
     */
    public String toStringMultiline() {
        return Serializer.INSTANCE.serialize(this, true);
    }

    /**
     * For internal use only.
     */
    static final class Serializer extends StructSerializer<DownloadArg> {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void serialize(DownloadArg value, JsonGenerator g, boolean collapse) throws IOException, JsonGenerationException {
            if (!collapse) {
                g.writeStartObject();
            }
            g.writeFieldName("path");
            StoneSerializers.string().serialize(value.path, g);
            if (value.rev != null) {
                g.writeFieldName("rev");
                StoneSerializers.nullable(StoneSerializers.string()).serialize(value.rev, g);
            }
            if (!collapse) {
                g.writeEndObject();
            }
        }

        @Override
        public DownloadArg deserialize(JsonParser p, boolean collapsed) throws IOException, JsonParseException {
            DownloadArg value;
            String tag = null;
            if (!collapsed) {
                expectStartObject(p);
                tag = readTag(p);
            }
            if (tag == null) {
                String f_path = null;
                String f_rev = null;
                while (p.getCurrentToken() == JsonToken.FIELD_NAME) {
                    String field = p.getCurrentName();
                    p.nextToken();
                    if ("path".equals(field)) {
                        f_path = StoneSerializers.string().deserialize(p);
                    }
                    else if ("rev".equals(field)) {
                        f_rev = StoneSerializers.nullable(StoneSerializers.string()).deserialize(p);
                    }
                    else {
                        skipValue(p);
                    }
                }
                if (f_path == null) {
                    throw new JsonParseException(p, "Required field \"path\" missing.");
                }
                value = new DownloadArg(f_path, f_rev);
            }
            else {
                throw new JsonParseException(p, "No subtype found that matches tag: \"" + tag + "\"");
            }
            if (!collapsed) {
                expectEndObject(p);
            }
            return value;
        }
    }
}
